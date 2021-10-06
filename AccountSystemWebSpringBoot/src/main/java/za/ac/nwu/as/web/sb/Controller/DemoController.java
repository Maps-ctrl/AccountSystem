package za.ac.nwu.as.web.sb.Controller;

/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.za.ac.nwu.domain.dto.service.GeneralResponse;*/


import io.swagger.annotations.ApiOperations;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.service.GeneralResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.as.domain.services.GeneralResponse;
import za.ac.nwu.as.domain.services.Pong;

/*@RestController
public class DemoController {

    @GetMapping("/all")
    public GeneralResponse<String> getAll() {
        return new GeneralResponse<String>(successful:true, payload: "No types found");}
}
*/

@RestController
@RequestMapping("demo-controller")

public class DemoController {

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured account types", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The account was received ", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> getAll(
            @GeneralResponse<String> response = new GeneralResponse<> (successful: true, payload:"No types found");
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

