package API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import questionManager.QuestionManagerInterface;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/questions")
public class ControllerAPI {

    private QuestionManagerInterface questionManager;
    private int testQANumber;

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<String> responseWithQuestion() {

        testQANumber = (int) (Math.random() * questionManager.getQuestionsSize());

        return new ResponseEntity<>(questionManager.getQ(testQANumber), HttpStatus.OK);
    }

    /*
    @RequestMapping(method = RequestMethod.GET, path = {"/{ }"}
    public ResponseEntity<String> responseWithAnswer( , ) {

            }
*/
}
