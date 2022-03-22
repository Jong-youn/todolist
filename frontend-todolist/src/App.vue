<template>
  <div>
    <h1>TODO it!</h1>
    <to-do-input></to-do-input>
    <to-do-list></to-do-list>
    <to-do-footer></to-do-footer>
  </div>
</template>

<script>
import ToDoInput from './components/ToDoInput.vue'
import ToDoFooter from './components/ToDoFooter.vue'
import ToDoList from './components/ToDoList.vue'

export default {
  components:{
    ToDoInput,
    ToDoFooter,
    ToDoList
  }
}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F6;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
h1 {
  color: #2F3B52;
  font-weight: 900;
  margin: 2.5rem 0 1.5rem;
}
</style>