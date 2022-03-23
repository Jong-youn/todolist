<template>
  <div>
    <h1>TODO it!</h1>
    <to-do-input v-on:addTodo="addTodo"></to-do-input>
    <to-do-list v-bind:items="items"
                v-on:finishTodo="finishTodo" v-on:removeTodo="removeTodo"></to-do-list>
    <to-do-footer v-on:removeTodos="removeTodos"></to-do-footer>
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
  },
  data() {
    return {
      items: []
    }
  },
  created() {
    for (var i = 0; i < localStorage.length; i++) {
      this.items.push(JSON.parse(localStorage.getItem(localStorage.key(i))))
    }
  },
  methods: {
    finishTodo(item, idx) {
      this.items[idx].done = !this.items[idx].done
      localStorage.setItem(item.todo, JSON.stringify(item))
    },
    removeTodo(item, idx) {
      localStorage.removeItem(item.todo)
      this.items.splice(idx, 1)
    },
    addTodo(todo) {
      var value = {'done': false, 'todo': todo};
      localStorage.setItem(todo, JSON.stringify(value))
      this.items.push(value)
    },
    removeTodos() {
      localStorage.clear()
      this.items = []
    }
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