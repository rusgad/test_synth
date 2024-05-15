package com.mypackage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) throws IOException {
//        ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "ls -l");
//        InputStream inputStream = Main.class.getResourceAsStream("/main/resources/synth");
//        Process start = processBuilder.start();

        try {
            // Получение доступа к утилите из JAR-файла
            InputStream inputStream = Main.class.getResourceAsStream("/Just_project_with_synth/src/main/resources/synth");

            System.out.println("inputStream = " + inputStream);

            // Создание временного файла для утилиты
            File tempFile = File.createTempFile("synth", "");
            tempFile.deleteOnExit();

            // Копирование утилиты из JAR-файла во временный файл
            Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Запуск утилиты с помощью ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash", "-c", "./" + tempFile.getAbsolutePath() + " --help");
            Process process = processBuilder.start();

            // Обработка вывода или ошибок, если необходимо
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Дождитесь завершения процесса
            int exitCode = process.waitFor();
            System.out.println("Процесс завершен с кодом: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }





//        BufferedReader in = new BufferedReader(new InputStreamReader(start.getInputStream()));
//        String line;
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//        }





    }
}

