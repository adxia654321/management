// // src/router/index.js
// import { createRouter, createWebHistory } from 'vue-router';
// import Layout from '@/views/layout/index.vue'; // 你的 Layout 組件路徑

// const routes = [
//   {
//     path: '/login',
//     name: 'Login',
//     component: () => import('@/views/login/Index.vue') // 假設你的登入頁面
//   },
//   {
//     path: '/',
//     component: Layout, // 使用 Layout 組件作為父路由
//     redirect: '/dashboard', // 訪問根路徑時，重定向到儀表板 (或其他你想要的默認頁)
//     children: [
//       {
//         path: 'dashboard', // 相對路徑，完整路徑是 /dashboard
//         name: 'Dashboard',
//         // 這裡引用你的儀表板頁面組件
//         component: () => import('@/views/dashboard/Index.vue') // << 假設你有這個文件
//       },
//       {
//         path: 'emp',
//         name: 'EmpManagement',
//         component: () => import('@/views/emp/Index.vue') // 假設你的員工管理頁面
//       },
//       // ... 你之前推斷的其他子路由 (clazz, dept, log, report, stu)
//       // 例如:
//       // {
//       //   path: 'clazz',
//       //   name: 'ClazzManagement',
//       //   component: () => import('@/views/clazz/Index.vue')
//       // },
//     ]
//   },
//   {
//     path: '/:pathMatch(.*)*',
//     name: 'NotFound',
//     component: () => import('@/views/error/NotFound.vue') // 假設你有一個 404 頁面
//   }
// ];

// const router = createRouter({
//   history: createWebHistory(), // 或者 createWebHistory()
//   routes
// });

// export default router;