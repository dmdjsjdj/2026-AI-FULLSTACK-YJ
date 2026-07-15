/**
 * passport/index.js
 * ------------------------------
 * 로그인  : [local.js] Passport LocalStrategy로 인증 후 세션(serializeUser) 저장
 * 로그아웃 : Passport 세션기반으로 사용자 조회(deserializeUser) 후 세션 종료
 */
const passport = require('passport');
const local = require('./local');
const { findUserById } = require('../models/users');

module.exports = () => { 
    // 로그인 성공 시 사용자 pk를 세션 저장
    passport.serializeUser((user, done) => {   // 로그인 인증된 사용자 객체정보, 콜백(어떻게 처리됐어)
        done(null, user.APP_USER_ID);   // 에러, 세션에 저장할 비밀번호
     });
     // 세션에 저장돤 사용자 id로 db에서 사용자 조회
    passport.deserializeUser(async (id, done) => {  // id, 콜백(어떻게 처리됐어)
        try {
            const user = await findUserById(id);
           done(null, user);   // 조회된 사용자 객체 req.user에 저장
        } catch (error) {
        console.error('deserializeUser Error:', error);
            done(error);  
        }
    });
    local();   // LocalStrategy 등록
};
