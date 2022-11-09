<template>
     <div class="q-pa-md row items-start q-gutter-md flex flex-center">
          <q-card
            class="my-card bg-blue-white-10 text-black"
            v-for="(x, index) in tests"
            :key="x.id"
            style="width:44%"
          >
            <q-card-section class="row flex flex-center" v-if="tests.length>0" >
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
import BtnDeleteTest from '../components/BtnDeleteTest.vue'
export default {
  components: {
    BtnDeleteTest
  },
  props: {
    id: {
      type: String,
      required: true
    }
  },
  data () {
    return {
      tests: []
    }
  },
  created () {
    this.consultTestsOfStudent()
  },
  methods: {
    consultTestsOfStudent () {
      this.$axios
        .get('/test/student/' + this.id)
        .then((resp) => {
          this.tests = resp.data
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
