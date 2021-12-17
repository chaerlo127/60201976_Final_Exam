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
                      <v-list-item-title class="text-h5 mb-1" v-if="editMode">
                      <v-text-field v-model="value.name"></v-text-field>
                      </v-list-item-title>
                      <v-list-item-title class="text-h5 mb-1" @click="toggleEditMode" v-else>
                        {{value.name}}
                      </v-list-item-title>
                      <v-list-item-subtitle @click="toggleEditMode"> 저장된 갯수는 {{value.addbutton}}이고 Like 수는 {{value.likebutton}}입니다.</v-list-item-subtitle>
                    </v-list-item-content>

                    <v-list-item-avatar
                      tile
                      size="80"
                      color="grey"
                    ></v-list-item-avatar>
                  </v-list-item>

                  <v-card-actions>
                    <v-btn
                      outlined
                      rounded
                      text


                    @click="add"
                    >
                      Add
                    </v-btn>
                     <v-btn
                      outlined
                      rounded
                      text


                    @click="minus"
                    >
                      Subtract
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

    methods:{
      async add(){
        //frontend에서 버튼을 누르게 되면, 서버(backend) DB에 값 추가 됨
        await axios.request({
          method: 'PUT', //api : put
          url: new URL(this.value._links.large.href).pathname,
          //localhost:8080/clothes
          //localhost:8080/pants
          //localhost:8080/shirts
          headers: {'Content-Type': 'application/json'},
        });


        this.refresh();//스스로 refresh되어 값 바로 변경
        
      },

      async minus(){

          await axios.request({
          method: 'PUT', //api : put
          url: new URL(this.value._links.small.href).pathname, 
          //localhost:8080/clothes
          //localhost:8080/pants
          //localhost:8080/shirts
          headers: {'Content-Type': 'application/json'}, //header 형식 json
        });
        
        this.refresh();//스스로 refresh되어 값 바로 변경

      },
      async refresh(){ // refresh를 따로 하지 않더라도, 자동으로 해주는 것
        var response = await axios.get(new URL(this.value._links.self.href).pathname);

      //response 가 true면 실행
        if(response){ 
          this.value = response.data;
          this.$emit("input", this.value);
        }
      },

      toggleEditMode(){
        this.editMode =!this.editMode;
        this.$emit("change", this.value);//변경 값 저장
      }

    },


  }
</script>
