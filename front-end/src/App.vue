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

          href="/shop"
        >
         의류 결제 목록
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
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addClothes(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
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

            <Clothe @change="updateClothes(clothes)" 
            :is="clothes[index].type" v-model="clothes[index]" v-for="(clothe, index) in clothes" :key="index"></Clothe>

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>


<script>
import Shirt from './components/Shirt'//Shirt.vue import
import Pant from './components/Pant'//Pant.vue import
import Clothe from './components/Clothe'//Clothe.vue import
const axios = require('axios').default; //axios 문법 사용

export default {
  name: 'App', //public class App()
  components: {
    Shirt,//import file : Shirt.vue, Pant.vue, Clothe.vue
    Pant,
    Clothe
  },

 data: () => ({
      items: [
        'PANTS', //PANTS, SHIRTS 버튼을 누르면 자신이 원하는 옷 생성
        'SHIRTS'
      ],
      clothes:[

      ]
     
    }),
    created(){//생성자의 역할
    this.init(); //method 호출
    },

    methods:{
      async init(){
        const response = await axios.get("/pants"); 
        this.clothes = response.data._embedded.pants;
        
      },
      addClothes(item){
        if(item=="PANTS"){ //PANTS 버튼을 누르면 type은 Pant, 이름은 청바지, addbutton 1, likebutton 1로 기본 값 세팅
          this.clothes.push(
            {
              type: 'Pant',
              name: '청바지',
              addbutton: 1,
              likebutton: 1
            }
          );
        }else if (item=="SHIRTS"){ //SHIRTS 버튼을 누르면 type은 Shirt, 이름은 와이셔츠, addbutton 1, likebutton 1로 기본 값 세팅
          this.clothes.push(
            {
              type: 'Shirt',
              name: '와이셔츠',
              addbutton: 1,
              likebutton: 1
            }
          );
        }

        axios.request({
          method: 'POST', //api : post
          url: '/pants', //localhost:8080/pants
          headers: {'Content-Type': 'application/json'}, 
          data: this.clothes[this.clothes.length -1]
        });
      },
      //이름 변경 가능하게 하는 method
      updateClothes(clothes){
          axios.request({
          method: 'PATCH', //api : patch
          url: new URL(clothes._links.self.href).pathname, //localhost:8080/pants/__
          headers: {'Content-Type': 'application/json'},
          data: clothes
        });
      }


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
