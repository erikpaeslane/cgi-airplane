import { createApp } from 'vue'
import App from './App.vue'

import * as VueRouter from 'vue-router'

import FlightList from './components/FlightList.vue'
import FlightDetails from './components/FlightDetails.vue'

const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(process.env.BASE_URL),
    routes: [
        {
            path: '/flights',
            component: FlightList
        },
        {
            path: '/flights/:id',
            component: FlightDetails,
        }
    ],
});

router.beforeEach((to, from, next) => {
    window.scrollTo(0, 0);
    next();
})

router.beforeResolve((to, from, next) => {
    // Scroll to the top before route is resolved (including page refresh)
    window.scrollTo(0, 0);
    next();
});

const app = createApp(App);

app.use(router);
console.log('Vue app is mounting');
app.mount('#app');
