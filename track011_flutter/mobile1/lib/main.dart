import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('내 첫 Flutter 앱'),
        ),
        body: Center(
          child: Text('Hello Flutter!!-하이 바이!'),
        ),
      ),
    ),
  );
}

// Scaffold : 전체 기본 뼈대 - 상단바, 본문, 하단 탭 등을 제공하는 기본 위젯
// appBar : 상단 타이틀바
// body : 몸통구성