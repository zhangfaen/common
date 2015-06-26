cd Downloads/goagent-goagent-
#1413540279
cd Downloads/goagent-goagent-3e867d2/
#1413540280
ll
#1413540283
cd local/
#1413540283
ll
#1413540292
python proxy.py 
#1413541272
.
#1413541274
ll
#1413541276
.
#1413541289
cd goagent-goagent-0e2eb37/
#1413541293
cd server/
#1413541293
ll
#1413541306
python uploader.py 
#1413541362
.
#1413541364
cd local/
#1413541368
.
#1413541375
cd local/
#1413541377
ll
#1413541385
python proxy.py
#1413541570
ll
#1413541575
vim proxy.ini 
#1413541593
python proxy.py
#1413541648
.
#1413541655
cd goagent-goagent-3e867d2/
#1413541657
cd local/
#1413541660
python proxy.py
#1414827780
cd
#1414827786
cd Downloads/protobuf-2.5.0/
#1414827801
./configure 
#1414827818
./make
#1414827824
make
#1414828099
make install
#1414828115
sudo make install
#1414828135
protoc --version
#1414828177
which protoc
#1414828569
mvn
#1414828810
ll
#1414828832
vim install-sh 
#1414828897
protoc --java_out=src/main/java -I../src          ../src/google/protobuf/descriptor.proto
#1414828906
cd java/
#1414828908
protoc --java_out=src/main/java -I../src          ../src/google/protobuf/descriptor.proto
#1414828929
cd src/main/java/
#1414828930
ll
#1414828940
cd com/google/protobuf/
#1414828941
ll
#1414828948
:q
#1414828949
.
#1414829348
..
#1414829350
cd src/main/java/com/google/protobuf
#1414829351
ll
#1414829359
mkdir bin/
#1414829370
javac -d bin *.java
#1414829948
cd
#1414829953
cd dev/apache-maven-3.2.3/
#1414829955
pwd
#1414830033
vim ~/.bash_profile 
#1414830237
source ~/.bash_profile 
#1414830246
mvn --version
#1414830417
.
#1414830419
cd protobuf-2.5.0/
#1414830425
./configure 
#1414830443
make
#1414830544
make check
#1414830638
sudo make install
#1414830653
protoc --version
#1414830693
cd java/
#1414830699
mvn test
#1414831271
mvn package
#1414831757
protoc --java_out=src/main/java -I../src          ../src/google/protobuf/descriptor.proto
#1414831781
cd src/main/java/com/google/protobuf
#1414831783
mkdir bin
#1414831794
javac -d bin *.java
#1414831806
which javac
#1414831813
javac --version
#1414831818
javac -version
#1414831828
java -version
#1414831859
cd bin/
#1414831860
ll
#1414831862
.
#1414831900
jar cvf protobuf.jar com/
#1414831913
cd bin/
#1414831914
jar cvf protobuf.jar com/
#1414831917
ll
#1414831997
cp protobuf.jar ~/dev/dpi/flowgift/libs/
#1414832408
cd
#1414832424
cd Documents/workspace_android/
#1414832425
ll
#1414832429
cd Demo2
#1414832430
ll
#1414832434
cd proto/
#1414832461
protoc 
#1414832464
protoc --help
#1414832512
protoc -I=. --java_out=../src/ test.proto 
#1414832533
.
#1414832544
ll src/com/example/tutorial/AddressBookProtos.java 
#1414846509
git status
#1415009958
cd
#1415009961
cd dev/protobuf-2.5.0/
#1415009963
cd java/
#1415009968
mvn test
#1415010114
ll
#1415010120
cd target/
#1415010120
ll
#1415010122
.
#1415010125
ll
#1415010133
rm -rf target/
#1415010136
mvn test
#1415010267
..
#1415010269
cd protobuf-2.5.0/
#1415010281
./configure 
#1415010304
make
#1415010406
make check
#1415010500
sudo make install
#1415010513
which protoc
#1415010517
protoc --version
#1415010525
ll /usr/local/bin/protoc
#1415010530
cd java/
#1415010541
mvn test
#1415010649
mvn package 
#1415010701
mvn install
#1415011149
mvn package -P lite
#1415011167
ll
#1415011169
cd target/
#1415011170
ll
#1415011280
ll -h
#1415011306
cp protobuf-java-2.5.0.jar ~/Documents/workspace_android/Demo2/libs/
#1415011463
protoc --help
#1416618624
ssh zhangfaen2.bej
#1415531791
cd
#1415531794
cd Downloads/
#1415531795
ll
#1415531807
pwd
#1415532663
ll
#1415887755
ssh zhangfaen2.bej
#1416492953
curl -L github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh | sh
#1416553447
ht
#1416558401
cd ~/dev/workspace/offline/
#1416558402
ll
#1416558405
git fetch 
#1416558414
gitk
#1416558448
git log
#1416558484
git fetch origin
#1416558491
gitk
#1416558514
git branch -vvvv
#1416558522
gitk
#1416558535
git merge
#1416558555
git pull
#1416558574
gitk
#1416558716
git add .
#1416558718
git commit
#1416558750
git push origin
#1416558787
git status
#1416558847
ll
#1416558863
vim .gitignore
#1416558872
cd target/
#1416558873
ll
#1416558881
rm classes/Controller.class 
#1416558885
.
#1416558888
git status
#1416558930
git add .
#1416558933
git commit
#1416558950
git push origin
#1416558969
git status
#1416573378
ll
#1416573396
git status
#1416573446
git add .
#1416573449
git commit
#1416573481
git push origin
#1416573496
git help fetch
#1416573520
git help pull
#1416573577
git pull
#1416574372
git add .
#1416574377
git pull
#1416574390
git commit
#1416574406
git push origin
#1416577428
git status
#1416577435
git add .
#1416577438
git commit
#1416577452
git push origin
#1416632040
gitk
#1416632047
git fetch
#1416632070
gitk
#1416632093
man gitk
#1416632115
gitk -all
#1416632126
gitk --all
#1416632146
git help merge
#1416632286
git merge
#1416632295
git branch -vv
#1416632304
git merge master
#1416632312
gitk --all
#1416632329
git pull
#1416632361
gitk --all
#1416635153
git add .
#1416635155
git commit
#1416635184
git push origin
#1416635722
git log
#1416635879
git help rebase
#1416646663
git add .
#1416646667
git commit
#1416646689
git push origin 
#1416646714
git pull
#1416666748
git add .
#1416666753
git status
#1416666757
git commit
#1416666780
git push origin
#1416712742
git pull
#1416712909
gitk
#1416734700
cat /etc/shells 
#1416735118
wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | sh
#1416735135
wget
#1416735163
git clone git://github.com/robbyrussell/oh-my-zsh.git ~/.oh-my-zsh
#1416736199
cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc
#1416736216
chsh -s /bin/zsh
#1415285045
ssh zhangfaen2.bej
#1415346376
cd
#1415346386
cd dev/dpi/flowgift/
#1415346391
git fetch origin
#1415346403
gitk
#1415346433
git help fetch
#1415346485
git fetch -all
#1415346489
git fetch --all
#1415346497
gitk
#1415346511
git checkout master
#1415436283
git status
#1415436292
git add .
#1415436296
git commit
#1415436321
git push origin
#1415440322
git status
#1415440324
git add .
#1415440330
git commit
#1415440353
git push origin
#1415459605
git status
#1415459607
git add .
#1415459610
git commit
#1415459634
git push origin
#1415513381
git status
#1415513383
git add .
#1415513386
git commit
#1415513413
git push origin
#1415513758
git status
#1415513761
git add .
#1415513763
git commit
#1415513781
git push origin
#1415513788
gitk
#1415513799
git fetch origin
#1415513803
gitk
#1415518194
git status
#1415518197
git add .
#1415518200
git commit
#1415518224
git push origin
#1415518233
gitk
#1415521712
protoc --version
#1415521718
protoc --help
#1415521725
cd proto/
#1415521773
protoc -I=. --java_out=../src/ dpi.proto 
#1415521784
.
#1415521786
git status
#1415521983
git add .
#1415521986
git commit
#1415522019
git push origin
#1415524332
git status
#1415524335
git add .
#1415524337
git commit
#1415524358
git push origin
#1415524367
gitk
#1415533226
git status
#1415533228
git add .
#1415533231
git commit
#1415533248
gitk
#1415533278
git commit
#1415533282
git push origin
#1415602727
git status
#1415602730
git add .
#1415602732
git commit
#1415602773
git push origin
#1415602784
git fetch 
#1415602789
gitk
#1415604956
adb log
#1415604977
adb logcat
#1415605049
adb help logcat
#1415605904
adb logcat com.xwz.dpi.DpiStorageManager[B
#1415606124
adb logcat | grep "flowgi"
#1415606276
adb logcat
#1415609413
git --version
#1415609603
git status
#1415609609
gitk
#1415613457
git status
#1415613468
git add  src/com/xwz/dpi/NetworkBehaviorCollectingService.java
#1415613471
git status
#1415613476
git commit
#1415613517
git status
#1415613521
gitk
#1415613542
git push origin
#1415613551
git status
#1415613559
ll libs/armeabi
#1415613572
ll
#1415613580
vim .gitignore 
#1415613596
git status
#1415613609
vim .gitignore 
#1415613638
git status
#1415613659
git checkout .gitignore 
#1415613666
git status
#1415627631
cd src/
#1415627633
git add .
#1415627635
git status
#1415627645
git commit
#1415627679
gitk
#1415627737
git push origin
#1415696948
git status
#1415696953
git add .
#1415696955
git status
#1415696959
git commit
#1415697009
gitk
#1415697025
git push origin
#1415712636
curl http://henandpi.qiniudn.com/2014-11-11_20_29_04-460011364900314-8613141368140-?attname=&e=1415798961&token=ydAVqtyAaPLRF4UID3NOskXExgvXReFRFpKKuFdo:csdvF8W4InNoH35Jg7N5HbBip9c
#1415712667
curl http://henandpi.qiniudn.com/2014-11-11_20_29_04-460011364900314-8613141368140-
#1415712674
curl http://henandpi.qiniudn.com/2014-11-11_20_29_04-460011364900314-8613141368140-?attname=&e=1415798961&token=ydAVqtyAaPLRF4UID3NOskXExgvXReFRFpKKuFdo:csdvF8W4InNoH35Jg7N5HbBip9c
#1415712925
man curl
#1415713048
curl http://www.163.com
#1415884368
.
#1415884372
git fetch all
#1415884379
git fetch --all
#1415884387
gitk
#1415884918
python
#1415889192
git status
#1415889196
cd src/
#1415889198
git add .
#1415889201
git commit
#1415889223
git push origin
#1415889315
git status
#1415889322
git add .
#1415889329
git commit
#1415889343
git push origin
#1415969090
.
#1415969091
git status
#1415969094
cd src/
#1415969096
git add .
#1415969099
git commit
#1415969121
git push origin
#1415974302
git status
#1415974319
git add .
#1415974321
git commit
#1415974340
git push origin
#1416144584
.
#1416144587
git status
#1416144590
cd src/
#1416144593
git add .
#1416144596
git commit
#1416144619
git diff
#1416144623
gitk
#1416144736
git push origin
#1416553451
ht
#1416554130
ll
#1416554131
.
#1416554135
git status
#1416554143
cd src/
#1416554146
git add .
#1416554148
git status
#1416554155
git commit
#1416554180
git push origin
#1416554200
gitk
#1416554206
git fetch
#1416554222
gitk
#1416554324
git branch -vv
#1416554793
git branch -a -vv
#1416555950
git add .
#1416555952
git commit
#1416555979
git push origin
#1416560464
git add .
#1416560466
git status
#1416560472
git commit
#1416560485
gitk
#1416560502
git push origin
#1416562060
git add .
#1416562067
git status
#1416562077
git commit
#1416562097
git push origin
#1416636680
git status
#1416636685
git add .
#1416636692
git commit
#1416636715
git push origin
#1416744881
ssh zhangfaen2.bej
#1416230616
cd
#1416230622
cd dev/workspace/
#1416230623
ll
#1416230628
cd offline/
#1416230629
ll
#1416230631
vim pom.xml 
#1416231360
ll
#1416231372
cd target/
#1416231372
ll
#1416231402
cd classes/ListPrefix.class 
#1416231407
cd test-classes/
#1416231408
.
#1416231409
ll
#1416231423
cd src/
#1416231424
.
#1416232741
git init
#1416232750
git remote add origin https://zhangfaen@bitbucket.org/zhangfaen/dpi.git
#1416232768
git add .
#1416232771
git commit
#1416232787
git push origin
#1416232815
git branche -vv
#1416232821
git branch -vv
#1416232826
git push -u origin master
#1416478953
ll
#1416478986
vim .project 
#1416479052
ll ~/.m2/
#1416479056
du -h
#1416479079
du ~/.m2/
#1416479115
du -h ~/.m2/
#1416488767
ssh zhangfaen2.bej
#1416553257
.
#1416553257
ll
#1416553289
..
#1416553295
cd Documents/workspace_android/
#1416553295
ll
#1416553300
cd Demo2
#1416553301
ll
#1416553305
gitk
#1416553315
cd jni/
#1416553324
ht | grep build
#1416553326
ht
#1416553343
ndk-build
#1416553367
ll
#1416553457
history
#1416553481
~/dev/android-ndk-r10c/ndk-build 
#1416553630
gitk
#1416553681
ll
#1416553683
.
#1416553684
ll
#1416553687
cd libs/
#1416553688
ll
#1416553694
.
#1416554075
cd jni/
#1416554078
~/dev/android-ndk-r10c/ndk-build 
#1416554094
.
#1416554096
git add .
#1416554099
git status
#1416554103
git commit
#1416554109
git push origin
#1416557503
cd jni/
#1416557506
~/dev/android-ndk-r10c/ndk-build 
#1416557675
ll ../libs/armeabi
#1416557750
.
#1416557752
cd libs/
#1416557753
nm
#1416557856
nm -gC armeabi/libdpi_dll.so 
#1416557864
nm -g armeabi/libdpi_dll.so 
#1416557871
nm armeabi/libdpi_dll.so 
#1416557887
readelf
#1416557891
man nm
#1416557910
nm armeabi/libdpi_dll.so -a
#1416557918
nm x86/libdpi_dll.so -a
#1416558151
.
#1416558152
cd jni/
#1416558159
~/dev/android-ndk-r10c/ndk-build 
#1416558255
du ../libs/ 
#1416558259
du ../libs/ -h
#1416558263
~/dev/android-ndk-r10c/ndk-build 
#1416558270
du ../libs/ -h
#1416558280
.
#1416558281
cd libs/
#1416558282
du -h
#1416558293
du 
#1416558300
du -r
#1416558303
man du
#1416558313
du -d 10
#1416558342
.
#1416558344
cd jni/
#1416558347
~/dev/android-ndk-r10c/ndk-build 
#1416558353
.
#1416558356
cd libs/
#1416558360
du -h
#1416576596
git status
#1416576607
.
#1416576607
ll
#1416576611
cd libs/
#1416576612
ll
#1416576628
.
#1416576630
git add .
#1416576634
git commit
#1416576641
gitk
#1416576657
git push origin
#1416576689
cd jni/
#1416576693
~/dev/android-ndk-r10c/ndk-build 
#1416735196
ll ~/.oh-my-zsh/
#1416735202
du -h
#1416735209
cd .gi
#1416735217
ll ~/.oh-my-zsh/.git/
#1416735225
ll ~/.oh-my-zsh/.git/objects/
#1416735228
ll ~/.oh-my-zsh/.git/objects/info/
#1416735232
ll ~/.oh-my-zsh/.git/objects/pack/
#1416735272
cd ~/.oh-my-zsh/
#1416735275
du -h
#1416735288
ll .git/
#1416735400
du -h
a
ll
zsh 
