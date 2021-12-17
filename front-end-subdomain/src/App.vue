<template>
  <v-app id="inspire">
    <v-app-bar
      app
      color="white"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="grey darken-1"
          size="32"
        ></v-avatar>

        <v-btn
          v-for="link in links"
          :key="link.href"
          :href="link.href"
          text
        >
          {{ link.title }}
        </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item @click="showCart = true">
                  <v-list-item-content>
                    <v-list-item-title>
                      카트보기
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="70vh"
              rounded="lg"
            >
              <Cart v-if="showCart">
              </Cart>

            <Clothe v-else v-model="clothes[index]" v-for="(clothe, index) in clothes" :key="index"></Clothe>

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>

import Clothe from './components/Clothe.vue' //Clothe.vue import
import Cart from './components/Cart.vue' //Cart.vue import
const axios = require('axios').default; //axios 문법 사용

export default {
  name: 'App', //public class App()
  components: {
    Clothe, Cart //import file : Clothe.vue, Cart.vue
  },

 data: () => ({
      links: [
        {title: '카트담기', href:"/"} // core domain으로 이동하는 버튼 카트담기
      ],
      items: [
        'PANTS', //PANTS, SHIRTS
        'SHIRTS'
      ],
      clothes:[

      ],
      showCart: false //showCart method default value false
     
    }),
    created(){ //생성자의 역할
    this.init();
    },

    methods:{

      showCart(){
        this.showCart = true; //showCart button click하면 true
      },
      async init(){
        const response = await axios.get("/pants"); // core domain Pant 값 불러오기
        this.clothes = response.data._embedded.pants; 
        
      },
    }

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
