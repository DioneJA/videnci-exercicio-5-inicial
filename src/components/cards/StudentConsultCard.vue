<template>
      <q-card
        class="my-card bg-blue-grey-10 text-white column flex flex-center"
        style="max-width: 650px"
      >
        <q-card-section>
          <div class="text-h6"><strong>ID: </strong>{{ student.id || 0}}</div>
          <div class="text-subtitle1">
            <strong>Nome: </strong>{{ student.name }}
          </div>
          <div v-if="student.amountTests > 0">
            <div class="text-subtitle1">
              <strong>Média: </strong>{{ student.average.toFixed(2) }}
            </div>
            <div class="text-subtitle1">
              <strong>Menor nota: </strong>{{ student.lowestGrade }}
            </div>
            <div class="text-subtitle1">
              <strong>Maior nota: </strong>{{ student.highestGrade }}
            </div>
            <div class="text-subtitle1">
              <strong>Quantidade de provas realizadas: </strong
              >{{ student.amountTests }}
            </div>
          </div>
          <empty-card v-else>
          O aluno não possui nenhuma prova cadastrada!
         </empty-card>
          <test-card></test-card>
        </q-card-section>
        <btn-add-test/>
      </q-card>
</template>

<script>
import BtnAddTest from '../buttons/BtnAddTest.vue'
import TestCard from '../cards/TestCard.vue'
import EmptyCard from './EmptyCard.vue'
import { mapState, mapActions } from 'vuex'
export default {
  data () {
    return {
      id: this.$route.params.id
    }
  },
  components: {
    BtnAddTest, TestCard, EmptyCard
  },
  computed: {
    ...mapState(['student', 'tests'])
  },
  mounted () {
    this.consultStudent(this.id)
  },
  methods: {
    ...mapActions(['consultStudent'])
  },
  watch: {
    tests () {
      this.consultStudent(this.id)
    }
  }
}
</script>

<style>

</style>
