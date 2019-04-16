package api.file.dupe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api")
public class ProjectApiController {

    private List<List<String>> result;

    @PostMapping(value = "/products/save", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<String> saveFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        result = new ArrayList<List<String>>();
        result=FileOperations.handleFile(multipartFile);
        return new ResponseEntity<>("completed", OK);
    }

    @GetMapping(value = "/products/all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<List<List<String>>> saveFile() {
        return new ResponseEntity<>(result, OK);
    }

}