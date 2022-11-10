<template>
  <q-layout view="lHh Lpr lFf" class="text-grey-12">
    <q-header elevated>
      <q-toolbar class="bg-grey-8">
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="leftDrawerOpen = !leftDrawerOpen"
          style="padding:1%"
        />

        <q-toolbar-title>
          CRUD Alunos
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if
      bordered
      content-class="bg-grey-9"
    >
      <q-list>
        <q-item-label
          header
          class="text-grey-12 "
        >
         Opções
        </q-item-label>
        <EssentialLink
          v-for="link in essentialLinks"
          :key="link.title"
          v-bind="link"
          exact
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import EssentialLink from 'src/components/EssentialLink.vue'

const linksData = [
  {
    title: 'Home',
    icon: 'home',
    link: '/'
  },
  {
    title: 'Ver maior nota',
    icon: 'bolt',
    link: '/highest'
  }
]

export default {
  name: 'MainLayout',
  components: {
    EssentialLink
  },
  data () {
    return {
      leftDrawerOpen: false,
      essentialLinks: linksData
    }
  }
}
</script>
