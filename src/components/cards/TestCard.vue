<template>
     <div class="q-pa-md row items-start q-gutter-md flex flex-center">
          <q-card
            class="my-card bg-blue-white-10 text-black"
            v-for="(x, index) in tests"
            :key="x.id"
          >
            <q-card-section class="row flex flex-center">
              <div>
                <div class="text-h6">
                  <strong>Prova: </strong>{{ index + 1 }}
                </div>
                <div class="text-subtitle1">
                  <strong>ID: </strong>{{ x.id }}
                </div>
                <div class="text-subtitle1">
                  <strong>Nota: </strong>{{ x.value }}
                </div>
              </div>
              <btn-delete-test :id="x.id"></btn-delete-test>
            </q-card-section>
          </q-card>
        </div>
</template>

<script>
import BtnDeleteTest from '../buttons/BtnDeleteTest.vue'
import { mapActions, mapState } from 'vuex'
export default {
  components: {
    BtnDeleteTest
  },
  data () {
    return {
      id: this.$route.params.id
    }
  },
  computed: {
    ...mapState(['tests'])
  },
  created () {
    this.fetchTests(this.id)
  },
  methods: {
    ...mapActions(['fetchTests'])
  }
}
</script>

<style lang="scss" scoped>

</style>
