package com.kirin.storage.services.integration;

import com.kirin.storage.response.ProductResponse;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * Шлюз, через который приложение отправляет сущность ProductResponse для записи в файл.
 * Вход в канал textInputChannel.
 */
@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateway {

    /**
     * Метод записи информации о добавленном продукте в файл
     * @param filename название файла с расширением
     * @param product объект ProductResponse для записи в файл
     */
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, ProductResponse product);

}
