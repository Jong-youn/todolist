import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

const storage = {
  fetch() {
    const arr = [];
    for (var i = 0; i < localStorage.length; i++) {
      arr.push(JSON.parse(localStorage.getItem(localStorage.key(i))))
    }
    return arr
  }
}

export const store = new Vuex.Store({
  state: {
    items: storage.fetch()
  },
  mutations: {
    finishTodo (state, payload) {
      state.items[payload.idx].done = !state.items[payload.idx].done
      localStorage.setItem(payload.item.todo, JSON.stringify(payload.item))
    },
    removeTodo(state, payload) {
      localStorage.removeItem(payload.item.todo)
      state.items.splice(payload.idx, 1)
    },
    addTodo(state, todo) {
      var value = {'done': false, 'todo': todo};
      localStorage.setItem(todo, JSON.stringify(value))
      state.items.push(value)
    },
    removeTodos(state) {
      localStorage.clear()
      state.items = []
    }
  }
})