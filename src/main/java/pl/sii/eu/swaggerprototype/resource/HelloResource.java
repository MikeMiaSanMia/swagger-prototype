package pl.sii.eu.swaggerprototype.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/hello")
@Api(value = "Class HelloResource", description = "Shows Endpoints for HelloResource")
public class HelloResource {

    //@GetMapping("/get")
    @ApiOperation(value = "Returns: Hello World from Sii")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is Continue"),
                    @ApiResponse(code = 401, message = "401 is Unauthorized"),
                    @ApiResponse(code = 403, message = "403 is Forbidden"),
                    @ApiResponse(code = 404, message = "404 is Not Found")
            }
    )
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String helloGet() {
        return "Hello World from Sii";
    }

    //@PostMapping("/add")
    @ApiOperation(value = "Returns: Welcome in Sii POST method: and argument value")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String helloPost(@RequestBody final String hello) {
        return "Welcome in Sii POST method: " + hello;
    }

    @ApiOperation(value = "Returns: Welcome in Sii PUT method: and argument value")
    @PutMapping("/put")
    public String helloPut(@RequestBody final String hello) {
        return "Welcome in Sii PUT method: " + hello;
    }

}
