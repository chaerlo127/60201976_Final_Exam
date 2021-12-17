<template>
  <Clothe v-model="value">
    <template v-slot:buttons>
    <v-btn
      outlined
      rounded
      text


    @click="Like_it"
    >
    Like it
    </v-btn>
    </template>
  </Clothe>
  

  
</template>

<script>
const axios = require('axios').default;
import Clothe from './Clothe' //Clothe.vue import

  export default {
    name: 'Pant',//import file : Clothe.vue

    components:{
      Clothe
    },
    mixins: [Clothe],


    methods:{
      async Like_it(){ //await를 사용하기 위해 pet의 vue 파일이 아닌 직접 method 추가

        await axios.request({
          method: 'PUT', //api method : put
          url: new URL(this.value._links.like.href).pathname,//url : localhost:8080/pants
          headers: {'Content-Type': 'application/json'},
        });
        
         this.refresh();
      }
    },


  }
</script>
