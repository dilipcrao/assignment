package dvlasearch;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFileDetailsInADirectory {
    private Path path = Paths.get(""); // Points to the root directory of the current project
    // a Directory contains various test files including a CSV with multiple Vehicle details
    private  String testDir = path.toAbsolutePath().toString()+"/src/test/resources/files/";
    private static final Logger log = LoggerFactory.getLogger(ListFileDetailsInADirectory.class);

    @Test
    public void listFileDetails() throws IOException{
        File folder = new File(testDir);
        File[] listOfFiles = folder.listFiles();
        System.out.println("no. of files: "+listOfFiles.length);
        for (int i=0; i<listOfFiles.length; i++)
            if (listOfFiles[i].isFile()) {
                Path filePath = new File(listOfFiles[i].getName()).toPath();
                String [] fileDetails = listOfFiles[i].getName().split("\\.");// seperator to capture the file type
                System.out.println("File>>>" + listOfFiles[i].getName() + " MIME type is>>>" + Files.probeContentType(filePath)+" File size>>>"+listOfFiles[i].length()+"  Extension is>>>"+fileDetails[1]);
                //prints in console

                log.info("File>>>" + listOfFiles[i].getName() + "  MIME type is>>>" + Files.probeContentType(filePath)+"File size is>>>"+listOfFiles[i].length()); //logging the details
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println(" Directory>>>" + listOfFiles[i].getName());
                log.info(" Directory>>>" + listOfFiles[i].getName()); //Logging the details
            }

    }

}