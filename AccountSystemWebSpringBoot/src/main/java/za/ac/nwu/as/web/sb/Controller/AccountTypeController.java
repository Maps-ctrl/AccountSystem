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
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.as.logic.flow.FetchAccountTypeFlow;
import java.util.List;

/*@RestController
public class DemoController {

    @GetMapping("/all")
    public GeneralResponse<String> getAll() {
        return new GeneralResponse<String>(successful:true, payload: "No types found");}
}
*/

@RestController
@RequestMapping("Account-type")

public class AccountTypeController {
    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow,
                                 @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow)
    {

        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured account types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The account types returned ", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll(){
            List<AccountTypeDto> accountType = fetchAccountTypeFlow.getAllAccountTypes();
            GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<> ( true, accountType );
            return new ResponseEntity<>(response, HttpStatus.OK);
    }


    //Creates new entities which can be added to the database other than miles eg bucks
    @PostMapping("")
    @ApiOperation(value = "Creates new account", notes = "Creates new account type in Database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The account was created successfully ", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> create(
            @ApiParam(value = "Request body to create a new account Type", required =true)
            @RequestBody AccountType accountType) {
        AccountType accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}


