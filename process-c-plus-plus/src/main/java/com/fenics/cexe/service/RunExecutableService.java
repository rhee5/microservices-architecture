package com.fenics.cexe.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class RunExecutableService {

    public List<String> runExecutable() throws IOException, InterruptedException {
        List<String> output = new ArrayList<>();

        // make sure executable is in resources
        ClassPathResource resource = new ClassPathResource("findlogs301sg.exe");
        Path tempExecutable = Files.createTempFile("findlogs301sg", ".exe");
        Files.copy(resource.getInputStream(), tempExecutable, StandardCopyOption.REPLACE_EXISTING);

        // only if execute permission not provided
        // tempExecutable.toFile().setExecutable(true);

        ProcessBuilder processBuilder = new ProcessBuilder(tempExecutable.toAbsolutePath().toString());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        }

        int exitCode = process.waitFor();
        System.out.println("Execution of C++ executable has exit code: " + exitCode);
        System.out.println("Output: " + output);

        Files.delete(tempExecutable);

        return output;
    }
}
