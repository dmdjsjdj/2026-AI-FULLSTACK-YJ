import 'package:flutter/material.dart';
import 'shared/components/app_layout.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'APPLE 소셜 앱',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.blue, // 파란색 테마헤더
          foregroundColor: Colors.white, // 글자 하얀색
        ),
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => const AppLayout(
              child: Center(
                child: Text(
                  'BLUE상단바 🎉',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
              ),
            ),
      },
    );
  }
}