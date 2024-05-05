package com.rum.ksc_back.Services;

import com.rum.ksc_back.domain.Rep.EssayRep;
import com.rum.ksc_back.domain.Rep.EssayRepHome;
import com.rum.ksc_back.domain.Rep.EssayRepPage;
import com.rum.ksc_back.domain.Ron.Essay;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EssayServices {
    List<EssayRepHome> homing();

    EssayRepPage essayPage(int essayId, int userId);
    boolean like(int userId,int essayId);
    boolean unLike(int userId,int essayId);
    boolean collection(int userId,int essayId);
    boolean unCollection(int userId,int essayId);
}
