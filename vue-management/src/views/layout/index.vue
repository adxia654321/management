
<script setup>
import { Avatar, Document, Histogram, HomeFilled, InfoFilled, Menu, Promotion, Share, Tools } from '@element-plus/icons-vue';

</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header class="header">
        <span class="title">呱呱課程輔助系統</span>
        <span class="right_tool">
          <a href="">
            <el-icon><EditPen /></el-icon> 修改密碼 &nbsp;&nbsp;&nbsp;&nbsp;|
          </a>
          <a href="">
            <el-icon><SwitchButton /></el-icon> 登出
          </a>
        </span>
      </el-header>

      <el-container>
        <!--左側菜單-->
        <el-aside width="200px" class="aside">
          <el-menu>
            <el-menu-item index="/index">
              <el-icon><Promotion /></el-icon>首頁
            </el-menu-item>

            <!--班級管理菜單-->
            <el-sub-menu index="/manage">
              <template #title>
                <el-icon><Menu /></el-icon>班級學生管理
              </template>

                <el-menu-item index="/clazz"><el-icon><HomeFilled /></el-icon>班級管理</el-menu-item>
                <el-menu-item index="/stu"><el-icon><UserFilled /></el-icon>學生管理</el-menu-item>
            </el-sub-menu>

            <!--部門員工菜單-->
            <el-sub-menu index="system">
              <template #title>
                <el-icon><Tools /></el-icon>部門員工管理
              </template>
                <el-menu-item index="/dept"><el-icon><HelpFilled /></el-icon>部門管理</el-menu-item>
                <el-menu-item index="/emp"><el-icon><Avatar /></el-icon>員工管理</el-menu-item>
              
            <!--數據統計菜單-->
            </el-sub-menu>
            <el-sub-menu index="/report">
              <template #title>
                <el-icon><Histogram /></el-icon>數據統計管理
              </template>

                <el-menu-item index="/empReport"><el-icon><InfoFilled /></el-icon>員工數據統計</el-menu-item>
                <el-menu-item index="/stuReport"><el-icon><Share /></el-icon>學生數據統計</el-menu-item>
                <el-menu-item index="/log"><el-icon><Document /></el-icon>日誌訊息統計</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-aside>
        <el-main> 右側核心區域 </el-main>
      </el-container>
    </el-container>
  </div>
</template>


<style >
/* 全局样式，确保布局占满整个视口高度 */
html,
body,
#app, /* 假设 #app 是您Vue应用的根元素 */
.common-layout {
  height: 100%;
  margin: 0px;
  padding: 0px;
}

*,
*::before,
*::after {
  box-sizing: inherit;
}


/* 使根 el-container 填满 .common-layout */
.common-layout > .el-container {
  height: 100%;
}

.header {
  background-image: linear-gradient(
    to right,
    #00547d,
    #007fa4,
    #00aaa0,
    #00d072,
    #a8eb12
  );
  /* Element Plus el-header 默认高度是 60px，这与图片效果很匹配 */
  /* 使用flex布局来排列标题和右侧工具栏 */
  display: flex;
  justify-content: space-between; /* 将标题推到左边，工具栏推到右边 */
  align-items: center; /* 垂直居中头部内容 */
  padding: 0 20px;
}

.title {
  color: white;
  font-size: 40px;
  font-family: "楷体", KaiTi, serif; /* 增加了 'KaiTi' 作为备选，以及通用衬线字体 */
  line-height: 60px; /* 匹配头部高度，用于文本块的垂直对齐 */
  font-weight: bolder;
}

.right_tool {
  display: flex; /* 如果内部结构更复杂，可以使项目在一行内对齐 */
  align-items: center; /* 垂直居中此span内的项目 */
}

.right_tool a {
  color: white;
  text-decoration: none; /* 去除链接下划线 */
  margin-left: 20px; /* “修改密码” 和 “退出登录” 链接之间的间距 */
  display: inline-flex; /* 使图标和文字良好对齐 */
  align-items: center; /* 垂直居中链接内的图标和文字 */
  font-size: 16px; /* 调整了链接的字体大小，使其比标题小 */
}

.right_tool a .el-icon {
  margin-right: 5px; /* 图标和其文字之间的间距 */
  /* 图标默认会继承颜色和字体大小，或者您可以明确设置 */
  /* 例如：font-size: 18px; 如果您希望图标比文字稍大 */
}

.aside {
}

.el-main {
}

/*
  关于文本内容的说明：
  您的 HTML 模板使用的是 "左側菜單" 和 "右側核心區域"。
  图片显示的是 "左侧菜单栏" 和 "右侧核心展示区域"。
  此 CSS 将会为您的 HTML 中提供的文本设置样式。
  "修改密码 |" 中的 "|" 在您的 HTML 中是链接文本的一部分。
  图片中它作为链接之间的分隔符。此处的样式与您的 HTML 结构相符。
*/
</style>

<!-- 
/* .header {
  background-image: linear-gradient(
    to right,
    #00547d,
    #007fa4,
    #00aaa0,
    #00d072,
    #a8eb12
  );
}

.title {
  color: white;
  font-size: 40px;
  font-family: 楷体;
  line-height: 60px;
  font-weight: bolder;
} */ -->

<!--git-->
