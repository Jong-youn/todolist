<template>
  <div class="inputBox shadow">
    <input type="text" id="item" v-on:keyup.enter="addItem">
    <span class="addContainer">
      <i class="addBtn fas fa-plus" aria-hidden="true" v-on:click="addItem"></i>
    </span>

  </div>
</template>

<script>
export default {
  methods: {
    addItem() {
      var todo = document.getElementById("item").value;
      var value = {'done': false, 'todo': todo};
      if (!todo.length.isEmpty()) {
        localStorage.setItem(todo, JSON.stringify(value))
        document.getElementById("item").value = ""
      }
    }
  }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
.closeModalBtn {
  color: #42b983;
}
</style>