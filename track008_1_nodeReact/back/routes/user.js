/************
 * routes-user.js
 * ---------------
 * 사용자관련 API 라우터
 */
//1. require
const express = require('express');
const passport = require('passport');

const router = express.Router(); 

const { createUser, findUserByEmail, findUserById, verifyUser
      , getAllUsers, updateUserNickname, deleteUser, findUserByNickname 
} = require('../models/users');
const isAuthenticated = require('../middlewares/isAuthenticated'); //## 미들웨어

//2. 부품
// post : /user/register (requestBody)  회원가입
/**
 * @swagger
 * /user/register:
 *   post:
 *     summary: 회원가입
 *     description: 새로운 사용자를 등록합니다.
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string } 
 *               password: { type: string } 
 *               nickname: { type: string } 
 *               mobile: { type: string } 
 *               mbtiTypeId: { type: integer } 
 *               ufile: { type: string } 
 *     responses:
 *       200:
 *         description: 회원가입성공
 */ 
router.post('/register', async(req, res)=>{
    try{
        const {email, password, nickname, mobile, mbtiTypeId, ufile} = req.body;
        await createUser(email, password, nickname, mobile, mbtiTypeId, ufile)
        res.status(201).json({message:'회원가입성공'});  // 200 ok, 201 created
    }catch(err) {
        console.error('register', err);
        res.status(500).json({message:'회원가입실패'});
    }
});

// post : /user/login    (requestBody)  로그인
/**
 * @swagger
 * /user/login:
 *   post:
 *     summary: 로그인 (테스트용)
 *     description: passport 이메일과 비밀번호를 인증해서 세션저장
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               email: { type: string } 
 *               password: { type: string } 
 *     responses:
 *       200:
 *         description: 로그인 (테스트용)
 */ 
router.post('/login', (req, res, next)=>{
    passport.authenticate('local', (err, user, info)=>{  // err, 성공시 반환된 사용자객체, 실패에러                
        if (err) return next(err);
        if (!user) return res.status(401).json({ message: info?.message || '로그인 실패' });

        req.login(user, (loginErr) => {  // passport가 제공해주는 함수, 인증된 사용자 객체를 세션에 저장하는 과정
            // serializeUser 호출되면 세션에 저장, 실행 / deserializeUser, req.user 사용자 객체 복원
            if (loginErr) return next(loginErr);
            const { PASSWORD, ...safeUser } = user;   // db에서 가져온 사용자 객체를 password 필드 제거
            //      뺄 필드,   나머지 속성들 그대로
            return res.status(200).json({message:'로그인 성공' , user: safeUser}); 
        }); 
    })(req, res, next);
});

// get : /user/check-email   이메일 중복확인
/**
 * @swagger
 * /user/check-email:
 *   get:
 *     summary: 이메일 중복 확인
 *     description: 입력한 이메일이 이미 존재하는지 확인합니다.
 *     parameters:
 *       - in: query
 *         name: email
 *         required: true
 *         schema: { type: string }
 *     responses:
 *       200:
 *         description: 확인 성공 (중복 여부는 응답 본문 참고)
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 available:
 *                   type: boolean
 *                   description: 사용 가능 여부
 *                 message:
 *                   type: string
 *                   description: 결과 메시지
 *       500:
 *         description: 이메일 중복 확인 실패
 */
router.get('/check-email', async (req, res) => {
    try {
        const { email } = req.query;

        const user = await findUserByEmail(email);

        if (user) {
            return res.json({
                available: false,
                message: '이미 사용 중인 이메일입니다.'
            });
        }

        res.json({
            available: true,
            message: '사용 가능한 이메일입니다.'
        });

    } catch (err) {
        console.error(err);
        res.status(500).json({
            message: '이메일 중복 확인 실패'
        });
    }
});

// get : /user/check-nickname   닉네임 중복확인
/**
 * @swagger
 * /user/check-nickname:
 *   get:
 *     summary: 닉네임 중복확인
 *     description: 입력한 닉네임이 이미 존재하는지 확인합니다.
 *     parameters:
 *       - in: query
 *         name: nickname
 *         required: true
 *         schema: { type: string }
 *     responses:
 *       200:
 *         description: 확인 성공 (중복 여부는 응답 본문 참고)
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 available:
 *                   type: boolean
 *                   description: 사용 가능 여부
 *                 message:
 *                   type: string
 *                   description: 결과 메시지
 *       500:
 *         description: 닉네임 중복 확인 실패
 */
router.get('/check-nickname', async (req, res) => {
    try {
        const { nickname } = req.query;

        const user = await findUserByNickname(nickname);

        if (user) {
            return res.json({
                available: false,
                message: '이미 사용 중인 닉네임입니다.'
            });
        }

        res.json({
            available: true,
            message: '사용 가능한 닉네임입니다.'
        });

    } catch (err) {
        console.error(err);
        res.status(500).json({
            message: '닉네임 중복 확인 실패'
        });
    }
});

router.get('/:id', async(req,res)=>{

    try{

        const user = await findUserById(req.params.id);

        if(!user){
            return res.status(404).json({
                message:'사용자가 없습니다.'
            });
        }

        res.json(user);

    }catch(err){
        console.error(err);
        res.status(500).json({
            message:'조회 실패'
        });
    }

});

// post : /user/logout   로그아웃
/**
 * @swagger
 * /user/logout:
 *   post:
 *     summary: 로그아웃 (테스트용)
 *     description: 세션/쿠키 없이 단순 응답 반환 (Passport 미적용)
 *     responses:
 *       200:
 *         description: 로그아웃 (테스트용)
 */ 
router.post('/logout', (req, res) => {   
    req.logout((err)=>{  // passport 제공함수, 현재 로그인된 사용자 정보 세션 제거
        if(err) return res.status(500).json({message: '로그아웃 실패'});
        req.session.destroy( ()=>{  
            res.clearCookie('connect.sid');   
            res.json({ message: '로그아웃 성공' });
        });
    });
}); 


// get  : /user/         전체사용자조회
/**
 * @swagger
 * /user/:
 *   get:
 *     summary: 전체 사용자 조회
 *     description: 로그인된 사용자만 전체 사용자 목록을 조회할 수 있습니다.
 *     responses:
 *       200:
 *         description: 사용자 목록 반환
 *       401:
 *         description: 인증 필요
 */
router.get('/', isAuthenticated, async(req, res)=>{
    try{
        const users = await getAllUsers();
        res.json(users);  
    }catch(err) {
        console.error('GetAllUsers', err);
        res.status(500).json({message:'사용자 조회 실패'});
    }
});

// patch: /user/{id}/nickname  닉네임수정
/**
 * @swagger
 * /user/{id}/nickname:
 *   patch:
 *     summary: 닉네임수정
 *     description: 특정 사용자의 닉네임 수정( 인증 미적용 )
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { tyep: integer }
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               nickname: { type: string }  
 *     responses:
 *       200:
 *         description: 수정 (테스트용)
 */ 
router.patch('/:id/nickname', isAuthenticated, async(req, res)=>{
    try{
        const {nickname} = req.body;
        await updateUserNickname( nickname, req.params.id );
        res.json({message:'닉네임 수정 완료'});
    }catch(err) {
        console.error('UpdateUserNickname', err);
        res.status(500).json({message:'닉네임 수정 실패'});
    }
});

// delete: /user/{id}  사용자삭제   deleteUser(id)
/**
 * @swagger
 * /user/{id}:
 *   delete:
 *     summary: 사용자삭제
 *     description: 특정 사용자의 사용자 삭제 ( 인증 미적용 )
 *     parameters:
 *       - in: path
 *         name: id
 *         required: true
 *         schema: { tyep: integer }
 *     responses:
 *       200:
 *         description: 사용자삭제
 */ 
router.delete('/:id', isAuthenticated, async(req, res)=>{
    try{
        await deleteUser( req.params.id );
        res.json({message:'사용자 삭제 완료'});  
    }catch(err) {
        console.error('DeleteUser', err);
        res.status(500).json({message:'사용자 삭제 실패'});
    }
});

//3. export
module.exports = router;