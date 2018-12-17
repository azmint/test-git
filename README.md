# Gitサンプル

- [Gitサンプル](#git%E3%82%B5%E3%83%B3%E3%83%97%E3%83%AB)
  - [Link(サンプル)](#link%08%E3%82%B5%E3%83%B3%E3%83%97%E3%83%AB)
  - [初期設定](#%E5%88%9D%E6%9C%9F%E8%A8%AD%E5%AE%9A)
  - [リモートリポジトリのクローン](#%E3%83%AA%E3%83%A2%E3%83%BC%E3%83%88%E3%83%AA%E3%83%9D%E3%82%B8%E3%83%88%E3%83%AA%E3%81%AE%E3%82%AF%E3%83%AD%E3%83%BC%E3%83%B3)
  - [インデックスへの追加](#%E3%82%A4%E3%83%B3%E3%83%87%E3%83%83%E3%82%AF%E3%82%B9%E3%81%B8%E3%81%AE%E8%BF%BD%E5%8A%A0)
    - [ワーキングツリーにある変更されたファイルを全て追加](#%E3%83%AF%E3%83%BC%E3%82%AD%E3%83%B3%E3%82%B0%E3%83%84%E3%83%AA%E3%83%BC%E3%81%AB%E3%81%82%E3%82%8B%E5%A4%89%E6%9B%B4%E3%81%95%E3%82%8C%E3%81%9F%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%82%92%E5%85%A8%E3%81%A6%E8%BF%BD%E5%8A%A0)
    - [特定のファイルを追加](#%E7%89%B9%E5%AE%9A%E3%81%AE%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%82%92%E8%BF%BD%E5%8A%A0)
    - [特定の拡張子のファイルを追加](#%E7%89%B9%E5%AE%9A%E3%81%AE%E6%8B%A1%E5%BC%B5%E5%AD%90%E3%81%AE%E3%83%95%E3%82%A1%E3%82%A4%E3%83%AB%E3%82%92%E8%BF%BD%E5%8A%A0)
    - [ディレクトリの指定](#%E3%83%87%E3%82%A3%E3%83%AC%E3%82%AF%E3%83%88%E3%83%AA%E3%81%AE%E6%8C%87%E5%AE%9A)
  - [バージョン管理の対象にする](#%E3%83%90%E3%83%BC%E3%82%B8%E3%83%A7%E3%83%B3%E7%AE%A1%E7%90%86%E3%81%AE%E5%AF%BE%E8%B1%A1%E3%81%AB%E3%81%99%E3%82%8B)

## Link(サンプル)

## 初期設定

```Console
git config --global user.name <名前>
git config --global user.email <メールアドレス>
```

## リモートリポジトリのクローン

指定されたディレクトリに元のリポジトリの内容を複製する。  
<宛先のディレクトリ>を省略した場合、カレントディレクトリにリポジトリそのものが複製される。

```Console
git clone <リモートリポジトリのアドレス> <宛先のディレクトリ>
```

| オプション | 説明 |
|:---------|:-----|
| -l | リポジトリがローカルマシーンからクローンされる場合、このフラグは通常の「Git aware」転送メカニズムをバイパスして、HEADとrefsディレクトリの下にある全てのオブジェクトをコピーすることによってクローンする。 |
| -s | リポジトリがローカルのマシーンにある場合、hard linksを用いる代わりに自動的に元のリポジトリとオブジェクトを共有するために.git/objects/info/alternatesを準備する。結果として、リポジトリは独自のオブジェクトなしで行ける。 |
| -n | クローンが完了した後、HEADのチェックをしない。 |

利用可能なプロトコルとその特性
| プロトコル | 特性 |
|:---------|:-----|
|Git|- 高速に通信できる|

## インデックスへの追加

指定されたファイルをインデックスに追加する。

```Console
git add <ファイル名>
```

### ワーキングツリーにある変更されたファイルを全て追加

新規作成されたファイルと変更されたファイルを全て追加する。  
削除されたファイルは、追加されない。

```Console
git add .
```

### 特定のファイルを追加

```Console
git add <ファイル名>
```

### 特定の拡張子のファイルを追加

```Console
git add *.<拡張子>
```

### ディレクトリの指定

```Console
git add <ディレクトリ名>/<ファイル名>
```

## バージョン管理の対象にする

リポジトリ内に設置されているファイルは、自動的に管理対象になっている。
