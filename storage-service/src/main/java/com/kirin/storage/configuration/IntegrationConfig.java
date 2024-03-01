package com.kirin.storage.configuration;

import com.kirin.storage.response.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Создание компонентов для определения потока интеграции для записи в файл информации
 * о добавленных на склад продуктах
 */
@Configuration
public class IntegrationConfig {

    /**
     * Название приложения для фиксирования в файле
     */
    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * Входной канал
     * @return экземпляр готового канала DirectChannel
     */
    @Bean
    public MessageChannel textInputChannel() {
        return new DirectChannel();
    }

    /**
     * Канал записи в файл
     * @return экземпляр готового канала DirectChannel
     */
    @Bean
    public MessageChannel fileWriterChannel() {
        return new DirectChannel();
    }

    /**
     * Трансформер. Забирает данные из канала textInputChannel, преобразует их и кладет
     * в канал fileWriterChannel. Здесь преобразуем ProductResponse в строку.
     */
    @Bean
    @Transformer(inputChannel = "textInputChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<ProductResponse, String> mainTransformer() {
        return product -> {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            StringBuilder sb = new StringBuilder();
            sb
                    .append("[").append(applicationName).append("] Добавлен продукт > ")
                    .append("Название: ").append(product.getName()).append(", ")
                    .append("кол-во: ").append(product.getCount()).append(", ")
                    .append("дата: ").append(LocalDateTime.now().format(dateFormat));
            return sb.toString();
        };
    }

    /**
     * Активатор сервиса сохранения в файл. ServiceActivator стоит в конце, на выходе из тракта.
     * В него передаются данные из канала fileWriterChannel.
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler messageHandler() {
        File file = new File("storage-service" + File.separator + "files");
        file.mkdir();
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(file);

        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true); // + \n

        return handler;
    }

}
