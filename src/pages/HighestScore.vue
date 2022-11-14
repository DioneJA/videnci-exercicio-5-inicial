<template>
    <div class="q-pa-md column items-start q-gutter-md flex flex-center" style="height: 50vh">
    <btn-home></btn-home>
    <q-card class="my-card" v-if="highestScore>0">
      <q-card-section class="bg-grey-9 text-white column flex flex-center">
        <div class="text-h5">A maior nota foi: </div>
        <div class="text-h5">{{highestScore}}</div>
      </q-card-section>
    </q-card>
    <empty-card v-else>Nenhuma prova foi cadastrada!</empty-card>
  </div>
</template>

<script>
import BtnHome from '../components/buttons/BtnHome.vue'
import EmptyCard from '../components/cards/EmptyCard.vue'
import { mapActions, mapState } from 'vuex'
export default {
  components: {
    BtnHome, EmptyCard
  },
  computed: {
    ...mapState(['highestScore'])
  },
  created () {
    this.getHighestScore()
  },
  methods: {
    ...mapActions(['getHighestScore'])
  }
}
</script>

<style lang="scss" scoped>

</style>
