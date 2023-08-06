package com.mongoDb.Service;

import com.mongoDb.Response.PincodeResponse;
import org.springframework.stereotype.Service;

@Service
public interface PinCodeService {

    PincodeResponse getPincodeData(Double pincode);
}
