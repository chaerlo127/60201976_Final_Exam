<template>
<v-card
              class="mx-auto"
              max-width="344"
              outlined
            >
                  <v-list-item three-line>
                    <v-list-item-content>
                      <div class="text-overline mb-4">
                        {{value.type}}
                      </div>
                      <v-list-item-title class="text-h5 mb-1">
                        {{value.name}}
                      </v-list-item-title> 
                      <v-list-item-subtitle> 저장된 갯수는 {{value.addbutton}}이고 Like 수는 {{value.likebutton}}입니다.</v-list-item-subtitle>
                    </v-list-item-content>

                    <v-list-item-avatar
                      tile
                      size="80"
                      color="grey"
                    ></v-list-item-avatar>
                  </v-list-item>

                  
                  <v-card-actions>
                    <v-chip v-if="inTheCart"> 카드에 담겼습니다.</v-chip>
                     <v-btn
                     v-else
                      outlined
                      rounded
                      text


                    @click="addToCart"
                    >
                      Cart
                    </v-btn>
                    <slot name = "buttons"> </slot>


                  </v-card-actions>
                </v-card>

</template>

<script>
const axios = require('axios').default; //axios 문법 사용
  export default {
    name: 'Clothe', 

    props:{
      value: Object,
      editMode: Boolean
    },
    data: ()=>{
      return{
        inTheCart: false //기본 값 false
      }
    },

    methods:{


      async addToCart(){
        
        var cartItem ={
          clothe: this.value._links.self.href,
          customer: "http://localhost:8088/customers/help@uengine.org", //backend에서 customer의 id가 help@uengine.org일 때에서의 cart id
          payment: {
            method:"신용카드", //payment의 method 신용카드 -> 새로운 옷 생성할 때, 기존에 backend의 옷은 처음 저장정보 그대로
            status: "결제완료"//payment의 status 신용카드 -> 새로운 옷 생성할 때, 기존에 backend의 옷은 처음 저장정보 그대로로
          },
          
        }

        await axios.request({
          method: 'POST',//api method: post
          url: "/cartItems", //uri localhost:8083/cartItems
          headers: {'Content-Type': 'application/json'},
          data: cartItem 
        });
        this.inTheCart = true; //card action이 있다면 true

        
      },

    },


  }
</script>
