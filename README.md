## NumberGuessingGame

数当てゲーム

## Overview

コンピュータがランダムで決めた数字（0 ～ 99）をプレイヤーが当てるゲーム

## Detail

- 数字を答えられるのは5回まで
- プレイヤーが入力した数が間違えている場合は、大きいか小さいかを教えてくれる
- 見事ピタリと当てることができればプレイヤーの勝ち

### インターフェース

#### CUI

実行例： 正解

``` 
数字を当ててみてね。
答えられるのは５回までだよ。
1回目：43
もっと大きい数字だよ
2回目：80
もっと小さい数字だよ
3回目：60
すごい！！3回で当てられちゃった！
```

実行例： 不正解

```
数字を当ててみてね。
答えられるのは５回までだよ。
1回目：43
もっと大きい数字だよ
2回目：76
もっと大きい数字だよ
3回目：90
もっと小さい数字だよ
4回目：81
もっと大きい数字だよ
5回目：87
もっと小さい数字だよ
残念！！ 正解は 85 でした！
```

## Structure Overview

- src/
    - App