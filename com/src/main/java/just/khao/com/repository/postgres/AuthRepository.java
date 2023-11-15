package just.khao.com.repository.postgres;

import just.khao.com.entity.AuthEntity;
import just.khao.com.entity.GoogleToken;
import just.khao.com.model.IssueTokenModel;
import just.khao.com.model.SignupModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthRepository {

    AuthEntity findByEmail(String email);

    void createGoogleAuth(@Param("google") GoogleToken googleToken, @Param("auth") SignupModel signupModel);

    boolean updateToken(IssueTokenModel issueTokenModel);
}
