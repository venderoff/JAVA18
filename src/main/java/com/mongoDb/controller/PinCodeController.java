package com.mongoDb.controller;

import com.mongoDb.Response.PincodeResponse;
import com.mongoDb.Service.PinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pincode")
public class PinCodeController {

    @Autowired
    PinCodeService service ;
    @GetMapping("/{pincode}")
    public ResponseEntity<PincodeResponse> getresp(@PathVariable("pincode") double pin){

        return new ResponseEntity<>(service.getPincodeData(pin), HttpStatus.OK) ;

    }
}
