package com.example.demo.controller;

import com.example.demo.exception.ErrorDetails;
import com.example.demo.exception.MobileNotFoundException;
import com.example.demo.model.Mobile;
import com.example.demo.service.MobileDaoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("mobiles")
public class MobileController {
    @Autowired
    private MobileDaoService mobileDaoService;

    @GetMapping
    @ApiResponse(description = "This method returns all mobile details ....")
    public List<Mobile> getAllMobiles(){
        return mobileDaoService.getAllMobiles();
    }

    @GetMapping( value = "/{mobile-id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<Mobile> getMobile(@PathVariable("mobile-id") int mobileId ){
        return  (mobileId <= 0)
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
                : ResponseEntity.ok().body(mobileDaoService.getMobileById(mobileId));
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMobile(HttpEntity<Mobile> httpEntity){
        httpEntity.getHeaders().forEach((k,v) -> {
            System.out.println("Key :" + k.toString());
            System.out.println("Value :" + v.toString());
        });
        mobileDaoService.saveMobile(httpEntity.getBody());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMobile(@RequestBody Mobile mobile){
        mobileDaoService.updateMobile(mobile);
    }

    @DeleteMapping("/{mobileId}")
    public boolean deleteMobileById(@PathVariable int mobileId){
        return mobileDaoService.deleteMobile(mobileId);
    }

    /*
    * Handling Controller level exception handler
    @ExceptionHandler(value = MobileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleMobileNotFoundException(MobileNotFoundException mfe){
        ErrorDetails error = new ErrorDetails();
        error.setErrorCode(mfe.getErrorCode());
        error.setErrorMessage(mfe.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

     */

}
