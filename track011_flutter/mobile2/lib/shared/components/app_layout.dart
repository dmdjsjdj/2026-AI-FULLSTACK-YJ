// React에서 레이아웃 : <Layout>{children}</Layout>
// ConsumerWidget 상속받으면 React에서 useSelector 처럼 전역인증

import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

// Riverpod 상태를 반응형으로 관찰하기 위해 StatelessWidget 대신 상속받는 클래스
class AppLayout extends ConsumerWidget {
  final Widget child;
  const AppLayout({super.key, required this.child});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    // 임시테스트용 - 로그인 여부 테스트
    final bool isLogined = DateTime.now().year > 2000;

    return Scaffold(
      appBar: AppBar(
        title: const Text('나의 소셜 앱'),
        actions: [
          if (isLogined) ...[
            const Center(
              child: Padding(
                padding: EdgeInsets.symmetric(horizontal: 8.0),
                child: Text('테스트유저님 환영합니다!'),
              ),
            ),
          ] else ...[
            TextButton(
              // 지정한 라우트 경로 이름('/login')으로 화면 전환
              onPressed: () => Navigator.pushNamed(context, '/login'),
              child: const Text('로그인', style: TextStyle(color: Colors.white)),
            ),
          ],
        ],
      ),
      body: child,
    );
  }
}