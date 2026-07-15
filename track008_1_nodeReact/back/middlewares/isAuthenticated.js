/**
 * middlewares/isAuthenticated.js 로그인 인증 미들웨어
 * ------------------------------
 * 로그인  후 인증된 사용자만 접근가능한 api
 * 인증이 안되면 401응답
 */
function isAuthenticated(req, res, next) {
  if (req.isAuthenticated && req.isAuthenticated()) {   
        return next();   
    }
    return res.status(401).json({ message: '로그인이 필요합니다.' });  
}

module.exports = isAuthenticated;   
