const { createUser, findUserByEmail, findUserById
        , verifyUser, getAllUsers, updateUserNickname
        , deleteUser, findUserByNickname } = require('./models/users');

async function runTests() {
    try{
        //1. 회원가입
        await createUser( 'z@z', 'z', 'zzz', '01011111111', '1', '1.png' );
        console.log('✅ createUser 성공');

        //2. 이메일로 조회
        const userByEmail = await findUserByEmail('z@z');
        console.log('✅ UserByEmail 성공');

        // ### 3. 사용자 조회 (ID 기준)
        const userByEmail = await findUserByEmail('z@z');
        console.log('✅ UserByEmail 성공');

    }catch(err) { console.log('❌테스트중 오류발생', err); }
}

runTests();

// node test1.js