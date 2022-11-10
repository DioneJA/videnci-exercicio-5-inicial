const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('src/pages/Index.vue') },
      { path: '/consult/:id', component: () => import('pages/ConsultStudent.vue') },
      { path: '/highest', component: () => import('pages/HighestScore.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
