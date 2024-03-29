package com.rum.ksc_back.Services.Essay;

import com.rum.ksc_back.domain.Rep.EssayRep;
import com.rum.ksc_back.domain.Ron.Essay;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EssayServices {
    List<EssayRep> homing();
}
