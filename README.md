# gitlocal
记录一些基本功能内容，方便以后拿来用

# git操作
1.mkdir /e/文件夹    -----创建本地仓库(文件夹)
2.git init    -----初始化文件夹，让其变为git可管理
3.git add .    ----提交本地仓库全部目录
4.git add filename    ----提交指定文件/目录
5.git status    ----查看状态
6.连接远端库(通过ssh加密传输，需设置)
    查看C盘用户目录下C:\Users\PCyzh\.ssh是否有这个目录有无id_rsa(私钥)和id_rsa.pub(公钥)这两个文件，没有就创建
    ssh-keygen -t rsa -C "yzhemail@vip.qq.com"    ----创建命令
7.git remoter add origin address    ----关联远端仓库
8.git push -u origin master    ----上传文件(远端库没有东西的时候)
若远端库有东西  |  git pull --rebase origin master    ----将远端文件pull下来，使用分支提交
9.git branch dev    ----创建分支  |  git checkout dev    ----切换分支  |  git branch    ----查看分支是否创建
10.git add filname/add .    ----提交文件  |  git checout master    ----切换到主分支合并
11.git merge dev    ----合并分支
12.git push origin master    ----上传到远端  |  git branch -D dev    ----删除分支 
