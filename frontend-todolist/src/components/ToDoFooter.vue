<template>
  <div class="clearAllContainer clearAllBtn" v-on:click="removeItems">
    Clear All
  </div>
</template>

<script>
export default {
  methods: {
    removeItems() {
      this.$store.commit('removeTodos')
    }
  }
}
</script>

<style scoped>
.clearAllContainer {
  width: 8.5rem;
  height: 50px;
  line-height: 50px;
  background-color: white;
  border-radius: 5px;
  margin: 0 auto;
}
.clearAllBtn {
  color: #e20303;
  display: block;
}
</style>