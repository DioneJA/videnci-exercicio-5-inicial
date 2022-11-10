<template>
    <div class="q-pa-md column items-start q-gutter-md flex flex-center" style="height: 50vh">
    <btn-home></btn-home>
    <q-card class="my-card" >
      <q-card-section class="bg-grey-9 text-white column flex flex-center">
        <div class="text-h5">A maior nota foi: </div>
        <div class="text-h5">{{score}}</div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import BtnHome from '../components/buttons/BtnHome.vue'
export default {
  components: {
    BtnHome
  },
  data () {
    return {
      score: 0
    }
  },
  created () {
    this.getHighestScore()
  },
  methods: {
    getHighestScore () {
      this.$axios
        .get('/test/highest')
        .then((resp) => {
          this.score = resp.data
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
