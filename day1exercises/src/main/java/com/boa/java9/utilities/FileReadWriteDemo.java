package com.boa.java9.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lombok.extern.slf4j.Slf4j;
//IO enhancements
public class FileReadWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Path path=Paths.get("src/main/resources/info.txt");
         String fileContent,newFileContent=null;
         try {
        	fileContent=Files.readString(path);
			System.out.println(fileContent);
			newFileContent=fileContent.replace("Image", "Images");
			System.out.println(newFileContent);
			path=Paths.get("src/main/resources/info_v1.txt");
			Files.writeString(path, newFileContent, StandardOpenOption.APPEND);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
