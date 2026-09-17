import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import '../data/auth_provider.dart';

// [수정] React의 컴포넌트 역할을 하는 ConsumerStatefulWidget 상속
class LoginPage extends ConsumerStatefulWidget {
  const LoginPage({super.key});

  @override
  ConsumerState<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends ConsumerState<LoginPage> {
  // Flutter의 폼 입력 제어 컨트롤러 (React의 useState/useRef 역할)
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();

  @override
  void dispose() {
    // 메모리 누수 방지를 위한 컨트롤러 객체 해제
    _emailController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  void _handleLogin() {
    final email = _emailController.text.trim();
    final password = _passwordController.text.trim();

    if (email.isEmpty || password.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('이메일과 비밀번호를 입력해주세요.')),
      );
      return;
    }

    // Notifier의 메서드를 호출(dispatch)하기 위해 ref.read().notifier 사용
    ref.read(authProvider.notifier).login({
      'email': email,
      'password': password,
    });
  }

  @override
  Widget build(BuildContext context) {
    // [핵심] 전역 AuthState 변화를 구독하여 UI 자동 재빌드 (Redux의 useSelector 역할)
    final authState = ref.watch(authProvider);

    // [핵심] 상태 변화에 따른 부수 효과(에러 스낵바 등)를 선언적으로 처리하는 listen 기능
    ref.listen<AuthState>(authProvider, (previous, next) {
      // 에러가 새로 발생했을 때만 스낵바 표시
      if (next.error != null && next.error != previous?.error) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text(next.error!), backgroundColor: Colors.red),
        );
      }
      
      // 로그인이 성공하여 토큰과 유저 정보가 채워졌다면 메인 화면으로 이동
      if (next.user != null && next.accessToken != null && mounted) {
        Navigator.pushNamedAndRemoveUntil(context, '/', (route) => false);
      }
    });

    return Scaffold(
      appBar: AppBar(title: const Text('로그인')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _emailController, 
              decoration: const InputDecoration(labelText: '이메일'),
              keyboardType: TextInputType.emailAddress, // 키보드 타입 최적화
            ),
            const SizedBox(height: 12),
            TextField(
              controller: _passwordController, 
              obscureText: true, 
              decoration: const InputDecoration(labelText: '비밀번호'),
            ),
            const SizedBox(height: 24),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                // 로딩 중에는 버튼을 비활성화(null) 처리
                onPressed: authState.loading ? null : _handleLogin,
                child: authState.loading 
                    ? const SizedBox(
                        width: 24,
                        height: 24,
                        child: CircularProgressIndicator(color: Colors.white, strokeWidth: 2),
                      ) 
                    : const Text('로그인'),
              ),
            ),
            const SizedBox(height: 12),
            TextButton(
              onPressed: () {
                Navigator.pushNamed(context, '/signup');
              },
              child: const Text('계정이 없으신가요? 회원가입하기'),
            ),
          ],
        ),
      ),
    );
  }
}
