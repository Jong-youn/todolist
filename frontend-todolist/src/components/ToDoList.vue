<template>
  <div>
    <ul>
      <li v-for="item in items" v-bind:key="item">
        <i class="checkBtn fas fa-check" v-bind:class="[ item.done ? 'checkBtnCompleted' : 'checkBtn' ]"></i>
        <span :class="{ 'textCompleted' : item.done == true }" v-on:click="finishItem(item)">{{ item.todo }}</span>
        <span class="removeBtn">
          <i class="removeBtn fas fa-trash-alt"></i>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: []
    }
  },
  created() {
    for (var i = 0; i < localStorage.length; i++) {
      this.items.push(JSON.parse(localStorage.getItem(localStorage.key(i))))
      console.log(this.items)
    }
  },
  methods: {
    finishItem(item) {
      item.done = !item.done
      localStorage.setItem(item.todo, JSON.stringify(item))
      console.log(this.items)
    }
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}
.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}
.checkBtnCompleted {
  color: #b3adad;
}
.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}
.removeBtn {
  margin-left: auto;
  color: #de4343;
}
/* transition css */
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to /* .list-leave-active below version 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
</style>