# 競プロ用ライブラリ
@eityans 用ライブラリ

## 一覧
### 常に含む
- `FastScanner`: 高速入力
- `long gcd(long a, long b)`: 最大公約数
- `long lcm (long a, long b)`: 最小公倍数

### 適宜使用する
- Combination: 二項分布の計算
- UnionFind: Union-Find木
- Mathmatics: 数学系ライブラリ
  - `List<long[]> factorization(long M)`: 素因数分解(index_0:素数 index_1:個数)
  - `long phi(long n)`: オイラーのφ関数（nに対して、nと互いに素である1以上n以下の自然数の個数）
  - `long[] divisor(long num)`: 約数の配列を返す
  - `long fact(long a)`: 階乗
  - `double distance(double X1, double Y1, double X2, double Y2)`: 2点間の距離

### あまり使わない(Keep)
- `int[] joinArray(int[] A, int[] B)`: 2つのint配列を連結させる
- `boolean arrayEqual(int[] A, int[] B)`: 2つのint配列が等しいかどうか判定する
- ` List<long[]> factorizationMerge(List<long[]> A, List<long[]> B)`: AとBの素因数分解の結果をもとに、A*Bの素因数分解の結果を返す

## 背景
提出用コードのテンプレートを所有してる。

これまではライブラリ全部盛りのテンプレートを使用していたが、逆に目的のライブラリを探すことが面倒になった。

常に含んでおきたいライブラリと、そうでもないライブラリに大別し、それらの一覧を記載することでライブラリの使用を簡潔にしたい。
