<!-- eslint-disable semi -->
<template>
  <div id="q-app">
    <transition mode="out-in">
      <router-view />
    </transition>
  </div>
</template>
<script>
export default {
  name: 'App'
}
</script>
