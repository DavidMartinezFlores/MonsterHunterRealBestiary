package com.dmf.mhbestiary.parsers;

import com.dmf.mhbestiary.models.Monster;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MonstersParser {

    public Monster[] getMonsters()
    {
        Monster[] monsters = new Monster[0];
        // El JSON que queremos parsear (en una cadena o archivo)
        String jsonFilePath = "./MonsterHunterBestiary/mhbestiary/info/monstersEN.json";

        try
        {
            // Leer el archivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Crear el ObjectMapper de Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Parsear el JSON de objetos Monster
            monsters = objectMapper.readValue(jsonContent, Monster[].class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return monsters;
    }

}
